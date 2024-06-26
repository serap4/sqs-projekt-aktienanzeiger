import { test, expect } from '@playwright/test';

test('test', async ({ page }) => {
    await page.goto('http://localhost:80/');
    await page.getByLabel('Wähle ein Datum').fill('2024-06-18');
    await page.locator('#options').selectOption('GOOGL');
    await page.getByRole('button', { name: 'Aktie Anzeigen!' }).click();
    await expect(page.getByRole('cell', { name: 'GOOGL' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '-06-18' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '177.14' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '177.385' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '174.1042' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '175.09' }).first()).toBeVisible();
    await expect(page.getByRole('cell', { name: '177.36' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '175.09' }).nth(1)).toBeVisible();
    await page.locator('#options').selectOption('MSFT');
    await page.getByRole('button', { name: 'Aktie Anzeigen!' }).click();
    await expect(page.getByRole('cell', { name: 'MSFT' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '-06-18' }).nth(1)).toBeVisible();
    await expect(page.getByRole('cell', { name: '449.705' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '450.14' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '444.89' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '446.34' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '449.44' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '446.42' })).toBeVisible();
    await page.locator('#options').selectOption('PYPL');
    await page.getByRole('button', { name: 'Aktie Anzeigen!' }).click();
    await expect(page.getByRole('cell', { name: 'PYPL' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '-06-18' }).nth(2)).toBeVisible();
    await expect(page.getByRole('cell', { name: '59.92' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '60.11' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '59.03' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '59.12', exact: true })).toBeVisible();
    await expect(page.getByRole('cell', { name: '60.29' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '59.1208' })).toBeVisible();
    await page.locator('#options').selectOption('KO');
    await page.getByRole('button', { name: 'Aktie Anzeigen!' }).click();
    await expect(page.getByRole('cell', { name: 'KO' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '-06-18' }).nth(3)).toBeVisible();
    await expect(page.getByRole('cell', { name: '62.53' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '62.82' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '62.44' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '62.63' }).first()).toBeVisible();
    await expect(page.getByRole('cell', { name: '62.62' })).toBeVisible();
    await expect(page.getByRole('cell', { name: '62.63' }).nth(1)).toBeVisible();
    await page.locator('#options').selectOption('AMZN');
    page.once('dialog', dialog => {
        console.log(`Dialog message: ${dialog.message()}`);
        dialog.dismiss().catch(() => {});
    });
    await page.getByRole('button', { name: 'Aktie Anzeigen!' }).click();
    await page.locator('#options').selectOption('KO');
    await page.getByRole('button', { name: 'Aktie aus der Datenbank lö' }).click();
    await expect(page.getByText('AbkürzungDatumEröffnungskursHöchstkursTiefstkursSchlusskursVorbörslichNachbörslichGOOGL2024-06-18177.14177.385174.1042175.09177.36175.09MSFT2024-06-18449.705450.14444.89446.34449.44446.42PYPL2024-06-')).toBeVisible();
    await page.getByRole('button', { name: 'Alle Aktien löschen' }).click();
    await expect(page.getByRole('table')).toBeVisible();
    await expect(page.getByText('Data deleted from cache')).toBeVisible();
});
