function processServerResponse(response, messageFunction, callback, noSuccessMessage, resultMessages) {
    var messages = {
        success : 'Succes',
        serverError : 'Server error'
    }

    if (angular.isDefined(resultMessages)) {
        messages = resultMessages
    }
    if (response.resultCode == 0) {
        if (!noSuccessMessage) {
            if (typeof messageFunction == 'function') {
                messageFunction(response.data);
            } else {
                toastr.success(messages.success)
            }
        }
        callback(response.data);
    } else if (response.resultCode == -1) {
        toastr.error(messages.serverError)
    }
    return null;
}