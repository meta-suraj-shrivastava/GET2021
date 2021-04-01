class Vehicle {

  //*************setters***************
  setCompanyName(name) {
    this.name = name;
  }
  setType(type) {
    this.type = type;
  }

  setVehicleNumber(vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }
  setEmployeeId(employeeId) {
    this.employeeId = employeeId;
  }
  setIdentification(identi) {
    this.identification = identi;
  }

  //It will update the price section accorting to the vehicle type
  updatePriceSection(event) {
    var children = document.getElementById("pricingSection").children;
    console.log("Updating");
    for (var i = 0; i < children.length; i++) {
      if (children[i].id == event.target.value) {
        children[i].style.display = "block";
      } else {
        children[i].style.display = "none";
      }
    }
  }

  //It will handle the press events occuring while entering vehcile details
  handlePress(event) {
    if (!event) event = window.event;
    var keyCode = event.code || event.key;
    if (keyCode == "Enter") {
      var currentNode = event.target;
      if (currentNode.id == "name") this.setCompanyName(currentNode.value);
      else if (currentNode.id == "vehNum")
        this.setVehicleNumber(currentNode.value);
      else if (currentNode.name == "type") this.setType(currentNode.value);
      else if (currentNode.id == "empId") this.setEmployeeId(currentNode.value);
      else if (currentNode.id == "ident")
        this.setIdentification(currentNode.value);
      var parent;
      var sibling = getSiblig(currentNode);
      if (sibling == null) {
        parent = getParent(currentNode);
        parent.classList.toggle("hide");
        sibling = getSiblig(parent);
      }
      currentNode.classList.toggle("hide");
      sibling.classList.toggle("hide");
    }
  }
}
