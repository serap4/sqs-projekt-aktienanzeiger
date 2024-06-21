import React from 'react';
import { render, screen, fireEvent, act } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect';
import App from './App';
import fetchMock from 'jest-fetch-mock';

fetchMock.enableMocks();

describe('App Component', () => {
  beforeEach(() => {
    fetchMock.resetMocks();
  });

  test('renders all elements correctly', () => {
    render(<App />);

    expect(screen.getByText(/Herzlich willkommen bei deinem Aktien Anzeiger/i)).toBeInTheDocument();
    expect(screen.getByLabelText(/Wähle eine Aktie aus die du anzeigen lassen möchtest/i)).toBeInTheDocument();
    expect(screen.getByLabelText(/Wähle ein Datum/i)).toBeInTheDocument();  // Updated the label text
    expect(screen.getByRole('button', { name: /Aktie Anzeigen!/i })).toBeInTheDocument();
    expect(screen.getByRole('button', { name: /Aktie aus der Datenbank löschen/i })).toBeInTheDocument();
    expect(screen.getByRole('button', { name: /Alle Aktien löschen/i })).toBeInTheDocument();
  });

  test('fetches and displays stock data on show button click', async () => {
    render(<App />);

    const stockData = [
      {
        symbol: 'IBM',
        from: '2023-06-20',
        open: 120.0,
        high: 125.0,
        low: 118.0,
        close: 124.0,
        preMarket: 119.0,
        afterHours: 125.5,
      },
    ];

    fetchMock.mockResponseOnce(JSON.stringify(stockData));

    fireEvent.change(screen.getByLabelText(/Wähle ein Datum/i), { target: { value: '2023-06-20' } });
    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'IBM' } });
    fireEvent.click(screen.getByRole('button', { name: /Aktie Anzeigen!/i }));

    await screen.findByText('IBM'); // wait for data to be fetched and displayed

    expect(screen.getByText('IBM')).toBeInTheDocument();
    expect(screen.getByText('2023-06-20')).toBeInTheDocument();
    expect(screen.getByText('120')).toBeInTheDocument();
    expect(screen.getByText('125')).toBeInTheDocument();
    expect(screen.getByText('118')).toBeInTheDocument();
    expect(screen.getByText('124')).toBeInTheDocument();
    expect(screen.getByText('119')).toBeInTheDocument();
    expect(screen.getByText('125.5')).toBeInTheDocument();
  });

  test('sends delete request on delete button click', async () => {
    render(<App />);

    fetchMock.mockResponseOnce('Aktie erfolgreich gelöscht');

    fireEvent.change(screen.getByLabelText(/Wähle ein Datum/i), { target: { value: '2023-06-20' } });
    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'IBM' } });
    fireEvent.click(screen.getByRole('button', { name: /Aktie aus der Datenbank löschen/i }));

    await screen.findByText('Aktie erfolgreich gelöscht'); // wait for the response

    expect(fetchMock).toHaveBeenCalledWith('http://localhost:8080/stock/delete/IBM/2023-06-20');
  });

  test('sends delete requests for all stocks on clear button click', async () => {
    render(<App />);

    const stockData = [
      { symbol: 'IBM', from: '2023-06-20' },
      { symbol: 'AAPL', from: '2023-06-21' },
    ];

    fetchMock.mockResponseOnce(JSON.stringify(stockData));

    fireEvent.change(screen.getByLabelText(/Wähle ein Datum/i), { target: { value: '2023-06-20' } });
    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'IBM' } });
    fireEvent.click(screen.getByRole('button', { name: /Aktie Anzeigen!/i }));

    await screen.findByText('IBM'); // wait for data to be fetched and displayed

    fireEvent.change(screen.getByLabelText(/Wähle ein Datum/i), { target: { value: '2023-06-21' } });
    fireEvent.change(screen.getByRole('combobox'), { target: { value: 'AAPL' } });
    fireEvent.click(screen.getByRole('button', { name: /Aktie Anzeigen!/i }));

    await screen.findByText('AAPL'); // wait for data to be fetched and displayed

    fetchMock.resetMocks();
    fetchMock.mockResponse('Aktien erfolgreich gelöscht');

    fireEvent.click(screen.getByRole('button', { name: /Alle Aktien löschen/i }));

    expect(fetchMock).toHaveBeenCalledTimes(2);
    expect(fetchMock).toHaveBeenCalledWith('http://localhost:8080/stock/delete/IBM/2023-06-20');
    expect(fetchMock).toHaveBeenCalledWith('http://localhost:8080/stock/delete/AAPL/2023-06-21');
  });
});
