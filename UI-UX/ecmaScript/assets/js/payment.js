class Payment{
    packages={
        "Cycle":{
            "daily":5,
            "Monthly":100,
            "yearly":500
        },
        "bike":{
            "daily":10,
            "Monthly":200,
            "yearly":1000
        },
        "car":{
            "daily":20,
            "Monthly":500,
            "yearly":35000
        }
    }


    //convert prices from one currency to another
    //@param - event
    //@param- currency symbol in unicode
    //@param - currencyValue with respect to INR
    convertPricesTo=(event,currency='\u{020B9}',currenyValue=1)=>{
        let currentSelected = document.getElementsByClassName("selected")[0];
        if(event!=undefined && event.target!=currentSelected){
        currentSelected.classList.remove('selected');
        event.target.classList.add("selected");
        }
        let newPrices = {
            "Cycle":{
                ...this.packages.Cycle
            },
            "bike":{
                ...this.packages.bike
            },
            "car":{
                ...this.packages.car
            }
        };
            newPrices.Cycle.daily = (this.packages.Cycle.daily*currenyValue).toFixed(1);
            newPrices.Cycle.Monthly = (this.packages.Cycle.Monthly*currenyValue).toFixed(1);
            newPrices.Cycle.yearly = (this.packages.Cycle.yearly*currenyValue).toFixed(1);

            newPrices.bike.daily = (this.packages.bike.daily*currenyValue).toFixed(1);
            newPrices.bike.Monthly = (this.packages.bike.Monthly*currenyValue).toFixed(1);
            newPrices.bike.yearly = (this.packages.bike.yearly*currenyValue).toFixed(1);

            newPrices.car.daily = (this.packages.car.daily*currenyValue).toFixed(1);
            newPrices.car.Monthly = (this.packages.car.Monthly*currenyValue).toFixed(1);
            newPrices.car.yearly = (this.packages.car.yearly*currenyValue).toFixed(1);

        this.updatePricesToDom(currency,newPrices);
    }

    //Update the prices in the dom
    updatePricesToDom=(currency,prices)=>{
        this.cycleBest.innerText = `${currency} ${prices.Cycle.Monthly}`;
        this.cycleDaily.innerText = `${currency} ${prices.Cycle.daily} Daily`;
        this.cycleMonthly.innerText = `${currency} ${prices.Cycle.Monthly} Monthly`;
        this.cycleYearly.innerText = `${currency} ${prices.Cycle.yearly} Yearly;`
    
        this.bikeBest.innerText = `${currency} ${prices.bike.Monthly}`;
        this.bikeDaily.innerText = `${currency} ${prices.bike.daily} Daily`;
        this.bikeMonthly.innerText = `${currency} ${prices.bike.Monthly} Monthly`;
        this.bikeYearly.innerText = `${currency} ${prices.bike.yearly} Yearly;`
    
        this.carBest.innerText = `${currency} ${prices.car.Monthly}`;
        this.carDaily.innerText = `${currency} ${prices.car.daily} Daily`;
        this.carMonthly.innerText = `${currency} ${prices.car.Monthly} Monthly`;
        this.carYearly.innerText = `${currency} ${prices.car.yearly} Yearly;`
    }


    //Initialize all the price tags
    getDomObjects=()=>{
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
    
    this.convertPricesTo();
}

}