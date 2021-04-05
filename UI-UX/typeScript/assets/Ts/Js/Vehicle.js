var Vehicle = /** @class */ (function () {
    function Vehicle() {
        var _this = this;
        //*************setters***************
        this.setCompanyName = function (name) {
            _this.name = name;
        };
        this.setType = function (type) {
            _this.type = type;
        };
        this.setVehicleNumber = function (vehicleNumber) {
            _this.vehicleNumber = vehicleNumber;
        };
        this.setEmployeeId = function (employeeId) {
            _this.employeeId = employeeId;
        };
        this.setIdentification = function (identi) {
            _this.identification = identi;
        };
        //It will update the price section accorting to the vehicle type
        this.updatePriceSection = function (inputId) {
            var prices = document.getElementById("pricingSection");
            var children = prices === null || prices === void 0 ? void 0 : prices.children;
            if (children)
                for (var i = 0; i < children.length; i++) {
                    if (children[i].id == inputId) {
                        children[i].style.display = 'block';
                    }
                    else {
                        children[i].style.display = "none";
                    }
                }
        };
        //It will handle the press events occuring while entering vehcile details
        this.handlePress = function (keyPress, currentInputId, nextInputId) {
            if (keyPress.key != 'Enter')
                return;
            var target = document.getElementById(currentInputId.toString());
            var nextTarget = document.getElementById(nextInputId.toString());
            if (target == null)
                return;
            if (currentInputId == "name")
                _this.setCompanyName(target.value);
            else if (currentInputId == "vehNum")
                _this.setVehicleNumber(target.value);
            else if (target.name == "type")
                _this.setType(target.value);
            else if (currentInputId == "empId")
                _this.setEmployeeId(target.value);
            else if (currentInputId == "ident")
                _this.setIdentification(target.value);
            target.classList.toggle("hide");
            nextTarget === null || nextTarget === void 0 ? void 0 : nextTarget.classList.toggle("hide");
        };
    }
    return Vehicle;
}());
var vehicle = new Vehicle();
