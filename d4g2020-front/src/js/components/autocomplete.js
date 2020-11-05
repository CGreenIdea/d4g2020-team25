const KEYCODE_DOWN = 40;
const KEYCODE_UP = 38;
const KEYCODE_ENTER = 13;
const MAX_RESULT = 20;

const addProposition = (item, valRegex, inp, hid, propositions) => {
    /* Create a DIV element for each matching element */
    const proposition = document.createElement('div');
    /* Highlight the matching element */
    proposition.innerHTML = item.label.replace(valRegex,
        '<span class="match">$&</span>');
    /* Save the data of this data */
    proposition.dataset.label = item.label;
    proposition.dataset.id = item.id;
    proposition.dataset.parent = item.parent;
    /* Execute a function when someone clicks on the item value (DIV element) */
    proposition.addEventListener('click', clickEvent => {
        /* Set the field to the selected value. */
        inp.value = clickEvent.currentTarget.dataset.label;
        hid.value = clickEvent.currentTarget.dataset.id;
        /* Close the list. */
        closeAllAutocompletionLists();
    });
    propositions.appendChild(proposition);
}

/**
 * Turns an input into an autocomplete field.
 *
 * @param {*} inp the text input that will trigger the apparition of the proposition list
 * @param {*} hid the hidden input where the ID of the selected value can be stored
 * @param {*} arr the array of values that can be looked upon
 */
const autocomplete = (inp, hid, arr) => {

    /* The focused proposition.  */
    let currentFocus = -1;

    /* This will be called when text is entered in the field */
    inp.addEventListener('input', inputEvent => {
        hid.value = -1;
        const val = inputEvent.target.value;
        const valRegex = new RegExp(val, 'i');

        /* Close any already open autocompletion list. */
        closeAllAutocompletionLists();

        /* If no text is set, just stop here anyway. */
        if (!val) {
            return false;
        }

        /* Reset the focused value. */
        currentFocus = -1;

        /* Create a DIV element that will contain the items (values). */
        const propositions = document.createElement('div');
        propositions.setAttribute('id', inputEvent.currentTarget.id + 'autocomplete-list');
        propositions.setAttribute('class', 'autocomplete-items');

        /* Append the DIV element as a child of the autocomplete container. */
        inputEvent.currentTarget.parentNode.appendChild(propositions);

        let displayed = 0;
        /*for each item in the array...*/
        arr.some(item => {
            /* Keep only elements that match the supplied proposition */
            if (valRegex.test(item.label)) {
                addProposition(item, valRegex, inp, hid, propositions);
                return ++displayed === MAX_RESULT;
            }
            return false;
        });
    });

    /* Add listeners on keyboard to listen the Keyboard */
    inp.addEventListener('keydown', keyEvent => {
        const propositions = document.querySelector(
            `#${keyEvent.target.id}autocomplete-list`);
        const propositionDivs = propositions
            ? propositions.querySelectorAll('div')
            : null;
        if (keyEvent.keyCode === KEYCODE_DOWN) {
            /*If the arrow DOWN key is pressed,
            increase the currentFocus variable:*/
            ++currentFocus;
            /*and and make the current item more visible:*/
            setActive(propositionDivs);
        } else if (keyEvent.keyCode === KEYCODE_UP) {
            /*If the arrow UP key is pressed,
            decrease the currentFocus variable:*/
            --currentFocus;
            /*and and make the current item more visible:*/
            setActive(propositionDivs);
        } else if (keyEvent.keyCode === KEYCODE_ENTER) {
            /*If the ENTER key is pressed, prevent the form from being submitted,*/
            keyEvent.preventDefault();
            if (currentFocus > -1) {
                /*and simulate a click on the 'active' item:*/
                if (propositionDivs) {
                    propositionDivs[currentFocus].click();
                }
            }
        }
    });

    /**
     * Set the 'autocomplete-active' class on focused elements
     * @param propositionDivs the divs containing the propositions
     */
    const setActive = propositionDivs => {
        if (!propositionDivs) {
            return;
        }
        /*start by removing the 'active' class on all items:*/
        removeActive(propositionDivs);

        /* Loop over the ends when at one extremity of the list */
        const propositionNumber = propositionDivs.length;
        if (currentFocus >= propositionNumber) {
            currentFocus = 0;
        }
        if (currentFocus < 0) {
            currentFocus = propositionNumber - 1;
        }

        /* Add the class on the correct element */
        propositionDivs[currentFocus].classList.add('autocomplete-active');
    };

    const removeActive = propositionDivs => propositionDivs.forEach(
        div => div.classList.remove('autocomplete-active'));
};

const closeAllAutocompletionLists = elmnt => {
    /*close all autocomplete lists in the document,
    except the one passed as an argument:*/
    document.querySelectorAll('.autocomplete-items').forEach(item => {
        if (elmnt !== item) {
            item.parentNode.removeChild(item);
        }
    });
};

export {autocomplete, closeAllAutocompletionLists};
