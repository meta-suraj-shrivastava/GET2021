var __assign = (this && this.__assign) || function () {
    __assign = Object.assign || function(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p))
                t[p] = s[p];
        }
        return t;
    };
    return __assign.apply(this, arguments);
};
var Pass = /** @class */ (function () {
    function Pass() {
        var _this = this;
        this.packages = {
            "Cycle": {
                "daily": '5',
                "Monthly": '100',
                "yearly": '500'
            },
            "bike": {
                "daily": '10',
                "Monthly": '200',
                "yearly": '1000'
            },
            "car": {
                "daily": '20',
                "Monthly": '500',
                "yearly": '35000'
            }
        };
        //convert prices from one currency to another
        //@param - event
        //@param- currency symbol in unicode
        //@param - currencyValue with respect to INR
        this.convertPricesTo = function (btnId, currency, currenyValue) {
            if (currency === void 0) { currency = "\u20B9"; }
            if (currenyValue === void 0) { currenyValue = 1; }
            var currentSelected = document.getElementsByClassName("selected")[0];
            var btn = document.getElementById(btnId.toString());
            if (btnId != undefined && (btn === null || btn === void 0 ? void 0 : btn.id) != currentSelected.id) {
                currentSelected.classList.remove('selected');
                btn === null || btn === void 0 ? void 0 : btn.classList.add("selected");
                var newPrices = {
                    "Cycle": __assign({}, _this.packages.Cycle),
                    "bike": __assign({}, _this.packages.bike),
                    "car": __assign({}, _this.packages.car)
                };
                newPrices.Cycle.daily = (Number.parseInt(_this.packages.Cycle.daily) * currenyValue).toFixed(1);
                newPrices.Cycle.Monthly = (Number.parseInt(_this.packages.Cycle.Monthly) * currenyValue).toFixed(1);
                newPrices.Cycle.yearly = (Number.parseInt(_this.packages.Cycle.yearly) * currenyValue).toFixed(1);
                newPrices.bike.daily = (Number.parseInt(_this.packages.bike.daily) * currenyValue).toFixed(1);
                newPrices.bike.Monthly = (Number.parseInt(_this.packages.bike.Monthly) * currenyValue).toFixed(1);
                ;
                newPrices.bike.yearly = (Number.parseInt(_this.packages.bike.yearly) * currenyValue).toFixed(1);
                newPrices.car.daily = (Number.parseInt(_this.packages.car.daily) * currenyValue).toFixed(1);
                newPrices.car.Monthly = (Number.parseInt(_this.packages.car.Monthly) * currenyValue).toFixed(1);
                newPrices.car.yearly = (Number.parseInt(_this.packages.car.yearly) * currenyValue).toFixed(1);
                _this.updatePricesToDom(currency, newPrices);
            }
        };
        //Update the prices in the dom
        this.updatePricesToDom = function (currency, prices) {
            if (_this.cycleBest && _this.cycleDaily && _this.cycleMonthly && _this.cycleYearly) {
                _this.cycleBest.innerText = currency + " " + prices.Cycle.Monthly;
                _this.cycleDaily.innerText = currency + " " + prices.Cycle.daily + " Daily";
                _this.cycleMonthly.innerText = currency + " " + prices.Cycle.Monthly + " Monthly";
                _this.cycleYearly.innerText = currency + " " + prices.Cycle.yearly + " Yearly;";
            }
            if (_this.bikeBest && _this.bikeDaily && _this.bikeMonthly && _this.bikeYearly) {
                _this.bikeBest.innerText = currency + " " + prices.bike.Monthly;
                _this.bikeDaily.innerText = currency + " " + prices.bike.daily + " Daily";
                _this.bikeMonthly.innerText = currency + " " + prices.bike.Monthly + " Monthly";
                _this.bikeYearly.innerText = currency + " " + prices.bike.yearly + " Yearly;";
            }
            if (_this.carBest && _this.carDaily && _this.carMonthly && _this.carMonthly && _this.carYearly) {
                _this.carBest.innerText = currency + " " + prices.car.Monthly;
                _this.carDaily.innerText = currency + " " + prices.car.daily + " Daily";
                _this.carMonthly.innerText = currency + " " + prices.car.Monthly + " Monthly";
                _this.carYearly.innerText = currency + " " + prices.car.yearly + " Yearly;";
            }
        };
    }
    //Initialize all the price tags
    Pass.prototype.getDomObjects = function () {
        this.cycleBest = document.getElementById('cycleBest');
        this.cycleDaily = document.getElementById('cycleDaily');
        this.cycleMonthly = document.getElementById('cycleMonthly');
        this.cycleYearly = document.getElementById('cycleYearly');
        this.bikeBest = document.getElementById('bikeBest');
        this.bikeDaily = document.getElementById('bikeDaily');
        this.bikeMonthly = document.getElementById('bikeMonthly');
        this.bikeYearly = document.getElementById('bikeYearly');
        this.carBest = document.getElementById('carBest');
        this.carDaily = document.getElementById('carDaily');
        this.carMonthly = document.getElementById('carMonthly');
        this.carYearly = document.getElementById('carYearly');
        this.updatePricesToDom("\u20B9", this.packages);
    };
    return Pass;
}());
var pass = new Pass();
(function () {
    pass.getDomObjects();
})();
