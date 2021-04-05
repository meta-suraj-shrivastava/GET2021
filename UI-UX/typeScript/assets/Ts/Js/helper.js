var Helper = /** @class */ (function () {
    function Helper() {
        //handle the submit task at the end of the form
        this.handleSubmit = function (currentFormId, nextFormId) {
            var cForm = document.getElementById(currentFormId.toString());
            var nForm = document.getElementById(nextFormId.toString());
            if (cForm)
                cForm.style.display = 'none';
            if (nForm)
                nForm.style.display = 'block';
        };
    }
    return Helper;
}());
var helper = new Helper();
