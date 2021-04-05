class Pass{
    cycleBest!: HTMLElement | null;
    cycleDaily!: HTMLElement | null;
    cycleMonthly!: HTMLElement | null;
    cycleYearly!: HTMLElement | null;
    bikeBest!: HTMLElement | null;
    bikeDaily!: HTMLElement | null;
    bikeMonthly!: HTMLElement | null;
    bikeYearly!: HTMLElement | null;
    carBest!: HTMLElement | null;
    carDaily!: HTMLElement | null;
    carMonthly!: HTMLElement | null;
    carYearly!: HTMLElement | null;
    packages:any={
        "Cycle":{
            "daily":'5',
            "Monthly":'100',
            "yearly":'500'
        },
        "bike":{
            "daily":'10',
            "Monthly":'200',
            "yearly":'1000'
        },
        "car":{
            "daily":'20',
            "Monthly":'500',
            "yearly":'35000'
        }
    }


    //convert prices from one currency to another
    //@param - event
    //@param- currency symbol in unicode
    //@param - currencyValue with respect to INR
    convertPricesTo=(btnId:String,currency:String='\u{020B9}',currenyValue:number=1)=>{
        let currentSelected:Element = document.getElementsByClassName("selected")[0];
        let btn:HTMLElement|null  =  document.getElementById(btnId.toString());
        if(btnId!=undefined && btn?.id!=currentSelected.id){

            currentSelected.classList.remove('selected');
            btn?.classList.add("selected");
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
            newPrices.Cycle.daily = (Number.parseInt(this.packages.Cycle.daily)*currenyValue).toFixed(1);
            newPrices.Cycle.Monthly = (Number.parseInt(this.packages.Cycle.Monthly)*currenyValue).toFixed(1);
            newPrices.Cycle.yearly = (Number.parseInt(this.packages.Cycle.yearly)*currenyValue).toFixed(1);

            newPrices.bike.daily = (Number.parseInt(this.packages.bike.daily)*currenyValue).toFixed(1);
            newPrices.bike.Monthly = (Number.parseInt(this.packages.bike.Monthly)*currenyValue).toFixed(1);;
            newPrices.bike.yearly = (Number.parseInt(this.packages.bike.yearly)*currenyValue).toFixed(1);

            newPrices.car.daily = (Number.parseInt(this.packages.car.daily)*currenyValue).toFixed(1);
            newPrices.car.Monthly = (Number.parseInt(this.packages.car.Monthly)*currenyValue).toFixed(1);
            newPrices.car.yearly = (Number.parseInt(this.packages.car.yearly)*currenyValue).toFixed(1);
            
            this.updatePricesToDom(currency,newPrices);
    }
    }

    //Update the prices in the dom
    updatePricesToDom=(currency:String,prices:any)=>{

        if(this.cycleBest&& this.cycleDaily&& this.cycleMonthly && this.cycleYearly){
        
        this.cycleBest.innerText = `${currency} ${prices.Cycle.Monthly}`;
        this.cycleDaily.innerText = `${currency} ${prices.Cycle.daily} Daily`;
        this.cycleMonthly.innerText = `${currency} ${prices.Cycle.Monthly} Monthly`;
        this.cycleYearly.innerText = `${currency} ${prices.Cycle.yearly} Yearly;`
        }
    if(this.bikeBest && this.bikeDaily && this.bikeMonthly && this.bikeYearly){
        this.bikeBest.innerText = `${currency} ${prices.bike.Monthly}`;
        this.bikeDaily.innerText = `${currency} ${prices.bike.daily} Daily`;
        this.bikeMonthly.innerText = `${currency} ${prices.bike.Monthly} Monthly`;
        this.bikeYearly.innerText = `${currency} ${prices.bike.yearly} Yearly;`
    }
    
    if(this.carBest && this.carDaily && this.carMonthly && this.carMonthly && this.carYearly){
        this.carBest.innerText = `${currency} ${prices.car.Monthly}`;
        this.carDaily.innerText = `${currency} ${prices.car.daily} Daily`;
        this.carMonthly.innerText = `${currency} ${prices.car.Monthly} Monthly`;
        this.carYearly.innerText = `${currency} ${prices.car.yearly} Yearly;`
    }
    }


    //Initialize all the price tags
    getDomObjects(){
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
    
    this.updatePricesToDom('\u{020B9}',this.packages);
}

}

var pass = new Pass();

(()=>{
    pass.getDomObjects();
})();