import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom';
import App from '../App';
import fetchMock from 'jest-fetch-mock';

fetchMock.enableMocks();

describe('App Component', () => {
  beforeEach(() => {
    fetchMock.resetMocks();
  });

  test('renders the component', () => {
    render(<App />);
    expect(screen.getByText(/Herzlich willkommen bei deinem Aktien Anzeiger/i)).toBeInTheDocument();
  });

  test('handles date change', () => {
    render(<App />);
    const dateInput = screen.getByLabelText(/Wähle ein Datum/i);
    fireEvent.change(dateInput, { target: { value: '2021-08-19' } });
    expect(dateInput.value).toBe('2021-08-19');
  });

  test('handles select change', () => {
    render(<App />);
    const selectInput = screen.getByDisplayValue('IBM');
    fireEvent.change(selectInput, { target: { value: 'AAPL' } });
    expect(selectInput.value).toBe('AAPL');
  });

  test('fetches stock data on show button click', async () => {
    fetchMock.mockResponseOnce(JSON.stringify([{ symbol: 'AAPL', from: '2021-08-19', open: 150, high: 155, low: 148, close: 154, preMarket: 149, afterHours: 153 }]));

    render(<App />);
    const dateInput = screen.getByLabelText(/Wähle ein Datum/i);
    fireEvent.change(dateInput, { target: { value: '2021-08-19' } });
    const selectInput = screen.getByDisplayValue('IBM');
    fireEvent.change(selectInput, { target: { value: 'AAPL' } });

    const showButton = screen.getByText(/Aktie Anzeigen/i);
    fireEvent.click(showButton);

    await waitFor(() => expect(fetch).toHaveBeenCalledWith('http://localhost:8080/stock/AAPL/2021-08-19'));

    await waitFor(() => {
      expect(screen.getByText(/AAPL/i)).toBeInTheDocument();
      expect(screen.getByText('2021-08-19')).toBeInTheDocument();
      expect(screen.getByText('150')).toBeInTheDocument();
    });
  });

  test('deletes stock data on delete button click', async () => {
    fetchMock.mockResponseOnce('Stock data deleted');

    render(<App />);
    const dateInput = screen.getByLabelText(/Wähle ein Datum/i);
    fireEvent.change(dateInput, { target: { value: '2021-08-19' } });
    const selectInput = screen.getByDisplayValue('IBM');
    fireEvent.change(selectInput, { target: { value: 'AAPL' } });

    const deleteButton = screen.getByText(/Aktie aus der Datenbank löschen/i);
    fireEvent.click(deleteButton);

    await waitFor(() => expect(fetch).toHaveBeenCalledWith('http://localhost:8080/stock/delete/AAPL/2021-08-19'));

    await waitFor(() => {
      expect(screen.getByText('Stock data deleted')).toBeInTheDocument();
    });
  });
});
