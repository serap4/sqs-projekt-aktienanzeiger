import React, { useState, useEffect } from 'react';
import './App.css';
import {Chart, Line} from 'react-chartjs-2';
import 'chart.js/auto';

function App() {
    const [selectedOption, setSelectedOption] = useState('IBM');
    const [selectedDate, setSelectedDate] = useState(null);
    const [deleteFeedback, setDeleteFeedback] = useState('');
    const [stockData, setStockData] = useState([]);
    const handleDateChange = (event) => {
        setSelectedDate(event.target.value);
    };
    const handleSelectChange = (event) => {
        setSelectedOption(event.target.value);
    }
    const handleClickShow = () => {
        if (!selectedDate || selectedDate === '') {
            console.log('Bitte wählen Sie ein Datum aus.');
            return;
        }
        fetch(urlFetch)
            .then(response => {
                if (!response.ok) {
                    if (response.status === 500) {
                        throw new Error('Sie haben zu viele Anfragen an die API gesendet. Bitte versuchen Sie es später erneut.');
                    }
                    throw new Error('Netzwerkantwort war nicht ok');
                }
                return response.text();
            })
            .then(data => {
                const stockDataObject = JSON.parse(data);
                const stockDataArray = Array.isArray(stockDataObject) ? stockDataObject : [stockDataObject];

                const isStockAlreadyAdded = stockData.some(stock => stock.symbol === selectedOption && stock.from === selectedDate);

                if (!isStockAlreadyAdded) {
                    setStockData(prevStockData => [...prevStockData, ...stockDataArray]);
                }

                console.log(stockDataArray);
            })
            .catch(error => {
                // Zeigen Sie die Fehlermeldung an
                alert(error.message);
            });
    };
    const handleClickDelete = () => {
        if (!selectedDate || selectedDate === '') {
            console.log('Bitte wählen Sie ein Datum aus.');
            return;
        }
        fetch(urlDelete)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Netzwerkantwort war nicht ok');
                }
                return response.text(); // Move response.text() here
            })
            .then(data => {
                setDeleteFeedback(data); // Speichern Sie die Rückmeldung

                setStockData(prevStockData => prevStockData.filter(stock => !(stock.symbol === selectedOption && stock.from === selectedDate)));
            })
            .catch(error => {
                console.error('Es gab ein Problem mit Ihrer Fetch-Anforderung:', error);
            });
    };
    const handleClickClear = () => {
        // Senden Sie eine Löschanfrage für jede Aktie in stockData
        stockData.forEach(stock => {
            const urlDelete = `http://localhost:8080/stock/delete/${stock.symbol}/${stock.from}`;
            fetch(urlDelete)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Netzwerkantwort war nicht ok');
                    }
                    return response.text();
                })
                .then(data => {
                    console.log('Löschrückmeldung:', data);
                })
                .catch(error => {
                    console.error('Es gab ein Problem mit Ihrer Fetch-Anforderung:', error);
                });
        });

        // Leeren Sie die Tabelle, indem Sie stockData auf ein leeres Array setzen
        setStockData([]);
    };
    const urlFetch = `http://localhost:8080/stock/${selectedOption}/${selectedDate}`;
    const urlDelete = `http://localhost:8080/stock/delete/${selectedOption}/${selectedDate}`;
    return (
        <div className="App">
            <h1>Herzlich willkommen bei deinem Aktien Anzeiger</h1>

            <label htmlFor="datePicker">Wähle eine Aktie aus die du anzeigen lassen möchtest:</label>
            <input type="date" id="datePicker" onChange={handleDateChange}/>
            <select id="options" value={selectedOption} onChange={handleSelectChange}>
                <option value="IBM">IBM</option>
                <option value="AAPL">Apple</option>
                <option value="GOOGL">Google</option>
                <option value="MSFT">Microsoft</option>
                <option value="TSLA">Tesla</option>
                <option value="AMZN">Amazon</option>
                <option value="PYPL">Paypal Holdings Inc.</option>
                <option value="INTC">Intel Corporation</option>
                <option value="JNJ">Johnson & Johnson</option>
                <option value="V">VISA INC.</option>
                <option value="NFLX">Netflix Inc.</option>
                <option value="DIS">Disney Company</option>
                <option value="PG">Procter & Gamble</option>
                <option value="KO">Coca-Cola Company</option>
                <option value="PEP">PepsiCo Inc.</option>
                <option value="WMT">Walmart Inc.</option>
                <option value="HD">Home Depot Inc.</option>
                <option value="NKE">Nike Inc.</option>
                <option value="MCD">McDonald's Corporation</option>
            </select>
            <button onClick={handleClickShow}> Aktie Anzeigen!</button>
            <button onClick={handleClickDelete}> Aktie aus der Datenbank löschen</button>
            <button onClick={handleClickClear}> Alle Aktien löschen</button>
            <label>{deleteFeedback}</label>
            <div style={{display: "flex", justifyContent: "center", marginTop: "80px"}}>
                <table style={{
                    width: "90%",
                    border: "1px solid black",
                    borderRadius: "5px",
                    padding: "10px",
                    borderCollapse: "separate",
                    borderSpacing: "10px",
                    backgroundColor: "#f2f2f2"
                }}>
                    <tr>
                        <th style={{border: "1px solid black", padding: "10px"}}>Abkürzung</th>
                        <th style={{border: "1px solid black", padding: "10px"}}>Datum</th>
                        <th style={{border: "1px solid black", padding: "10px"}}>Eröffnungskurs</th>
                        <th style={{border: "1px solid black", padding: "10px"}}>Höchstkurs</th>
                        <th style={{border: "1px solid black", padding: "10px"}}>Tiefstkurs</th>
                        <th style={{border: "1px solid black", padding: "10px"}}>Schlusskurs</th>
                        <th style={{border: "1px solid black", padding: "10px"}}>Vorbörslich</th>
                        <th style={{border: "1px solid black", padding: "10px"}}>Nachbörslich</th>
                    </tr>
                    {stockData.map((data, index) => (
                        <tr key={index}>
                            <td>{data.symbol}</td>
                            <td>{data.from}</td>
                            <td>{data.open}</td>
                            <td>{data.high}</td>
                            <td>{data.low}</td>
                            <td>{data.close}</td>
                            <td>{data.preMarket}</td>
                            <td>{data.afterHours}</td>
                        </tr>
                    ))}
                </table>
            </div>
        </div>
    );
}

export default App;
