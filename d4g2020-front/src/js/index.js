import {hideCard, generatePdf} from './components/card.js';
import {initSearchForm} from './business/search-form';
import {initCollapsables} from './components/collapsable.js';

initSearchForm();
initCollapsables();
hideCard();

document.getElementById("downloadPdf").addEventListener("click", () => {
    generatePdf();
});
