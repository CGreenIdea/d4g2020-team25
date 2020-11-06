const notifyError = error => {
// FIXME this answers the business need but is not a final implementation.
    alert('Une erreur est survenue.');
    console.error(error);
};

export {notifyError};
