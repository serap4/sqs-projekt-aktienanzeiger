import React, { useState, useEffect } from 'react';
import './App.css';
import {Chart, Line} from 'react-chartjs-2';
import 'chart.js/auto';

function App() {
    const [selectedOption, setSelectedOption] = useState('IBM');
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const handleSelectChange = (event) => {
        setSelectedOption(event.target.value);
    };
    const options = {
        responsive: true,
        scales: {
            y: {
                beginAtZero: true,
            },
        },
    };
    const fetchData = (timeseries) => {
        if (selectedOption) {
            fetch(`http://localhost:8080/stock/${selectedOption}/${timeseries}`)
                .then(response => response.json())
                .then(data => {
                    // Hier verarbeiten Sie die Daten und erstellen das Datenobjekt für Chart.js
                    const chartData = {
                        labels: data.map(entry => entry.date), // Angenommen, Ihre Daten haben ein 'date'-Feld
                        datasets: [{
                            label: 'Stock Price',
                            data: data.map(entry => entry.price), // Angenommen, Ihre Daten haben ein 'price'-Feld
                            borderColor: 'rgba(75, 192, 192, 1)',
                            backgroundColor: 'rgba(75, 192, 192, 0.2)',
                            borderWidth: 1
                        }]
                    };

                    // Erstellen Sie das Chart.js-Diagramm mit den Daten
                    const ctx = document.getElementById('myChart').getContext('2d');
                    new Chart(ctx, {
                        type: 'line',
                        data: chartData,
                        options: {
                            responsive: true,
                            scales: {
                                y: {
                                    beginAtZero: true
                                }
                            }
                        }
                    });
                })
                .catch(error => console.error('Error:', error));
        }
    };
    return (
      <div className="App">
          <h1>Herzlich willkommen bei deinem Aktien Anzeiger</h1>
          <div className="buttonContainer">
              <div className="buttonContainer">
                  <button className="button" onClick={() => fetchData('daily')}>Tägliche Aktie Zeigen</button>
                  <button className="button" onClick={() => fetchData('weekly')}>Wöchentliche Aktie Zeigen</button>
                  <button className="button" onClick={() => fetchData('monthly')}>Monatliche Aktie Zeigen</button>
              </div>
          </div>
          <label htmlFor="options">Wähle eine Aktie aus die du anzeigen lassen möchtest:</label>
          <select id="options" value={selectedOption} onChange={handleSelectChange}>
              <option value="IBM">IBM</option>
              <option value="AAPL">Apple</option>
              <option value="GOOGL">Google</option>
          </select>
          {selectedOption && <p>Du hast {selectedOption} ausgewählt.</p>}
          {data && <Line data={data} options={options} />}
      </div>
  );
}

export default App;
