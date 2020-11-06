import {
    autocomplete,
    dynamicAutocomplete,
    closeAllAutocompletionLists,
} from '../components/autocomplete';
import {notifyError} from '../components/error';
import {debounce} from '../utils/throttle';
import {showCard} from '../components/card';

const TYPING_THROTTLE = 200;

const regionIdInput = document.getElementById('region-id-input');
const departmentId = document.getElementById('department-id-input');
const cityInput = document.getElementById('city-input');

let cities = [];
let callCounter = 0;

function fetchData(endpoint) {
    return fetch(`${env.apiUri}/${endpoint}`, {
        method: 'GET',
        mode: env.mode,
    }).then(response => {
        if (response.status >= 200 && response.status <= 299) {
            return response.json();
        } else {
            throw Error(response.statusText);
        }
    });
}

const loadComboboxData = (endpoint, input, idInput, transformData) => {
    fetchData(endpoint).then(json => {
        autocomplete(input, idInput, json.map(item => transformData(item)));
    }).catch(error => notifyError(error));
};

const refreshCities = (input) => {
    if (!input) {
        cities = [];
        return;
    }

    const postalCode = /^\d+?/i.test(input);

    const callId = ++callCounter;
    const endpoint = postalCode
        ? `city/postal-code/${input}`
        : `region/${regionIdInput.value}/department/${departmentId.value}/city/name/${input}`;
    fetchData(endpoint).then(json => {
        if (callId === callCounter) {
            cities = json.map(cty => {
                return {
                    id: cty.ctyId,
                    label: `${cty.ctyName} (${cty.ctyPostalCode})`,
                };
            });
            // Trigger an input event to display the propositions
            cityInput.dispatchEvent(new Event('focus'));
        }
    }).catch(error => notifyError(error));
};

const initSearchForm = () => {
    // TODO disable inputs until data is loaded
    // FIXME todo
    /* Load data and init inputs */
    loadComboboxData(
        'region',
        document.getElementById('region-input'),
        regionIdInput,
        rgn => {
            return {
                id: rgn.rgnId,
                label: rgn.rgnName,
            };
        },
    );
    loadComboboxData(
        'department',
        document.getElementById('department-input'),
        departmentId,
        dpt => {
            return {
                id: dpt.dptId,
                label: `${dpt.dptCode} - ${dpt.dptName}`,
            };
        },
    );

    // TODO nice to have: upon selecting a region, filter available departments
    // TODO nice to have: upon selecting a region, filter cities
    // TODO nice to have: upon selecting a department, set region
    // TODO nice to have: upon selecting a department, filter cities

    cityInput.addEventListener('input', debounce(inputEvent => {
        refreshCities(inputEvent.target.value);
    }, TYPING_THROTTLE));
    dynamicAutocomplete(
        cityInput,
        document.getElementById('city-id-input'),
        () => cities,
    );

    /* Close all open lists when someone clicks on the document */
    document.addEventListener('click', clickEvent => {
        closeAllAutocompletionLists(clickEvent.target);
    });

    const searchBtn = document.getElementById('searchButton');

    searchBtn.addEventListener('click', clickEvent => {
        // TODO disable input while loading
        let cityId = document.getElementById('city-id-input').value;

        if (cityId != null && cityId > 0) {
            fetchData(`score/city/${cityId}`).then(json => {
                showCard(json);
            }).catch(error => notifyError(error));
        }
    });

    //For accessibility
    searchBtn.addEventListener("keydown", (event => {
        if (event.code === 'Space' || event.code === 'Enter') {
            document.getElementById('searchButton').click();
        }
    }));
};

export {initSearchForm};
