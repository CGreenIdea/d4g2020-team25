import {
    autocomplete,
    closeAllAutocompletionLists,
} from '../components/autocomplete';
import {notifyError} from '../components/error';

const loadComboboxData = (endpoint, input, idInput, transformData) => {
    fetch(`${env.apiUri}/${endpoint}`, {
        method: 'GET',
        mode: env.mode,
    }).then(response => {
        if (response.status >= 200 && response.status <= 299) {
            return response.json();
        } else {
            throw Error(response.statusText);
        }
    }).then(json => {
        autocomplete(input, idInput, json.map(item => transformData(item)));
    }).catch(error => notifyError(error));
};

const initSearchForm = () => {
    // TODO disable inputs until data is loaded
    // FIXME todo
    /* Load data and init inputs */
    loadComboboxData(
        'region',
        document.getElementById('region-input'),
        document.getElementById('region-id-input'),
        rgn => {
            return {
                id: rgn.rgnId,
                label: rgn.rgnName
            }
        }
    );
    loadComboboxData(
        'department',
        document.getElementById('department-input'),
        document.getElementById('department-id-input'),
        dpt => {
            return {
                id: dpt.dptId,
                label: `${dpt.dptCode} - ${dpt.dptName}`
            }
        }
    );

    // FIXME set filters based on what is selected

    /* Close all open lists when someone clicks on the document */
    document.addEventListener('click', clickEvent => {
        closeAllAutocompletionLists(clickEvent.target);
    });
};

export default initSearchForm;
