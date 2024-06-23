import { test, expect } from '@playwright/test';

test('sindAlleElementeSichtbarTest', async ({ page }) => {
    await page.goto('http://localhost:3000/');
    await expect(page.getByRole('heading', { name: 'Herzlich willkommen bei' })).toBeVisible();
    await expect(page.getByText('Wähle eine Aktie aus die du')).toBeVisible();
    await expect(page.getByLabel('Wähle ein Datum')).toBeVisible();
    await expect(page.locator('#options')).toBeVisible();
    await expect(page.getByRole('button', { name: 'Aktie Anzeigen!' })).toBeVisible();
    await expect(page.getByRole('button', { name: 'Aktie aus der Datenbank lö' })).toBeVisible();
    await expect(page.getByRole('button', { name: 'Alle Aktien löschen' })).toBeVisible();
    await expect(page.getByText('Herzlich willkommen bei deinem Aktien AnzeigerWähle eine Aktie aus die du')).toBeVisible();
    await expect(page.locator('#root div').filter({ hasText: 'Herzlich willkommen bei' }).locator('div')).toBeVisible();
    await expect(page.getByRole('table')).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Abkürzung' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Datum' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Eröffnungskurs' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Höchstkurs' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Tiefstkurs' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Schlusskurs' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Vorbörslich' })).toBeVisible();
    await expect(page.getByRole('cell', { name: 'Nachbörslich' })).toBeVisible();
});