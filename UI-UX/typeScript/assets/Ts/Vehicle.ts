

class Vehicle {
  name!: String;
  type!: String;
  vehicleNumber!: String;
  employeeId!: String;
  identification!: String;
  //*************setters***************
  setCompanyName=(name:String)=> {
    this.name = name;
  }
  setType=(type:String)=>{
    this.type = type;
  }

  setVehicleNumber=(vehicleNumber:String)=>{
    this.vehicleNumber = vehicleNumber;
  }
  setEmployeeId=(employeeId:String)=>{
    this.employeeId = employeeId;
  }
  setIdentification=(identi:String)=>{
    this.identification = identi;
  }

  //It will update the price section accorting to the vehicle type
  updatePriceSection=(inputId:String)=>{
    let prices:HTMLElement|null = document.getElementById("pricingSection");
    let children:HTMLCollectionOf<HTMLElement>|undefined = prices?.children as HTMLCollectionOf<HTMLElement>|undefined;
    if(children)
      for (var i = 0; i < children.length; i++) {
        if (children[i].id == inputId) {
          children[i].style.display = 'block';
      } else {
        children[i].style.display = "none";
      }
    }
  }

  //It will handle the press events occuring while entering vehcile details
  handlePress=(keyPress:Event,currentInputId:String,nextInputId:String)=>{
    if(keyPress.key!='Enter') return; 
    let target: HTMLInputElement | null = document.getElementById(
      currentInputId.toString()
    ) as HTMLInputElement | null;
    let nextTarget: HTMLInputElement | null = document.getElementById(
      nextInputId.toString()
    ) as HTMLInputElement | null;

    if(target == null) return;
      if (currentInputId== "name") this.setCompanyName(target.value);
      else if (currentInputId== "vehNum")
        this.setVehicleNumber(target.value);
      else if (target.name == "type") this.setType(target.value);
      else if (currentInputId== "empId") this.setEmployeeId(target.value);
      else if (currentInputId== "ident")
        this.setIdentification(target.value);

      target.classList.toggle("hide");
      nextTarget?.classList.toggle("hide");
    }
  }
var vehicle =  new Vehicle();