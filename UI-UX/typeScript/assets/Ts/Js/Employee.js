var EmployeeDetails = /** @class */ (function () {
    function EmployeeDetails() {
        var _this = this;
        //return true if password valiation  get success
        //@param - password
        this.isValidPass = function (password) {
            var regex = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}/;
            return regex.test(password.toString());
        };
        //return true if name valiation  get success
        //@param - name
        this.isValidName = function (name) {
            var regex = /^[A-Za-z]{2,}$/;
            return regex.test(name.toString());
        };
        //return true if conf password valiation  get success
        //@param - password
        this.isConfirmPassValid = function (password) {
            return _this.password.toString() == password.toString();
        };
        //return true if contact valiation  get success
        //@param - contact
        this.isValidContact = function (contact) {
            var regex = /^[\d]{8,10}$/;
            return regex.test(contact.toString());
        };
        //return true if emoal valiation  get success
        //@param - email
        this.isValidEmail = function (email) {
            var regEx = /^[a-zA-Z0-9]+@[a-z]{4,}.[a-z]{2,}(.[a-z]{2,4})?$/;
            return regEx.test(email.toString());
        };
        this.displayErrorMsg = function (tagId) {
            var errorMsg = document.getElementById(tagId.toString());
            if (errorMsg) {
                errorMsg.style.display = "block";
            }
        };
        this.removeErrorMsg = function (tagId) {
            var errorMsg = document.getElementById(tagId.toString());
            if (errorMsg) {
                errorMsg.style.display = "none";
            }
        };
        //It will handle the press events occuring while entering employee details
        this.handlePress = function (keyPress, currentInputId, nextInputId) {
            if (keyPress.key != 'Enter')
                return;
            var target = document.getElementById(currentInputId.toString());
            var nextTarget = document.getElementById(nextInputId.toString());
            if (!target)
                return;
            if (currentInputId == "fullName") {
                if (!_this.isValidName(target.value)) {
                    target.classList.add("error");
                    _this.displayErrorMsg("nameError");
                    return;
                }
                _this.name = target.value;
                target.classList.remove("error");
                _this.removeErrorMsg("nameError");
            }
            if (currentInputId == "email") {
                if (!_this.isValidEmail(target.value)) {
                    target.classList.add("error");
                    _this.displayErrorMsg("mailError");
                    return;
                }
                _this.mail = target.value;
                target.classList.remove("error");
                _this.removeErrorMsg("mailError");
            }
            if (currentInputId == "password") {
                if (!_this.isValidPass(target.value)) {
                    target.classList.add("error");
                    _this.displayErrorMsg("passError");
                    return;
                }
                _this.password = target.value;
                target.classList.remove("error");
                _this.removeErrorMsg("passError");
            }
            if (currentInputId == "confirm password") {
                if (!_this.isConfirmPassValid(target.value)) {
                    target.classList.add("error");
                    _this.displayErrorMsg("cnpError");
                    return;
                }
                target.classList.remove("error");
                _this.removeErrorMsg("cnpError");
            }
            if (currentInputId == "contact") {
                if (!_this.isValidContact(target.value)) {
                    target.classList.add("error");
                    _this.displayErrorMsg("contactError");
                    return;
                }
                target.classList.remove("error");
                _this.removeErrorMsg("contactError");
            }
            if (currentInputId == "gender")
                _this.gender = target.value;
            var label = document.getElementById("label-with-name");
            if (currentInputId == "fullName") {
                _this.name = target.value;
                console.log("In Full Name");
                if (label) {
                    label.innerText = "Hi " + _this.name + ", Can I get your " + nextInputId + ".";
                    label.classList.toggle("hide");
                    label.style.display = "block";
                }
            }
            else if (nextInputId != "empSubmit" && label) {
                label.innerText = "Please enter your " + nextInputId;
            }
            else {
                if (label)
                    label.innerText = "";
            }
            target.classList.toggle("hide");
            if (nextTarget)
                nextTarget.classList.toggle("hide");
            return false;
        };
    }
    return EmployeeDetails;
}());
var employee = new EmployeeDetails();
