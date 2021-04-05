//All the validation related to the Employee form can be done using this class object
interface EmpInterface {
  password: String;
  name: String;
  mail: String;
  gender: String;
}

class EmployeeDetails implements EmpInterface {
  password!: String;
  name!: String;
  mail!: String;
  gender!: String;
  //return true if password valiation  get success
  //@param - password

  isValidPass=(password: String)=>{
    let regex = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}/;
    return regex.test(password.toString());
  }

  //return true if name valiation  get success
  //@param - name
  isValidName=(name: String)=>{
    let regex = /^[A-Za-z]{2,}$/;
    return regex.test(name.toString());
  }

  //return true if conf password valiation  get success
  //@param - password
  isConfirmPassValid=(password: String)=>{
    return this.password.toString() == password.toString();
  }

  //return true if contact valiation  get success
  //@param - contact
  isValidContact=(contact: String)=>{
    let regex = /^[\d]{8,10}$/;
    return regex.test(contact.toString());
  }

  //return true if emoal valiation  get success
  //@param - email
  isValidEmail=(email: String)=>{
    let regEx = /^[a-zA-Z0-9]+@[a-z]{4,}.[a-z]{2,}(.[a-z]{2,4})?$/;
    return regEx.test(email.toString());
  }

  displayErrorMsg = (tagId: String) => {
    let errorMsg: HTMLElement | null = document.getElementById(
      tagId.toString()
    );
    if (errorMsg) {
      errorMsg.style.display = "block";
    }
  };

  removeErrorMsg = (tagId: String) => {
    let errorMsg: HTMLElement | null = document.getElementById(
      tagId.toString()
    );
    if (errorMsg) {
      errorMsg.style.display = "none";
    }
  };

  //It will handle the press events occuring while entering employee details
  handlePress = (keyPress:Event, currentInputId: String, nextInputId: String) => {

    if(keyPress.key != 'Enter' ) return;
    let target: HTMLInputElement | null = document.getElementById(
      currentInputId.toString()
    ) as HTMLInputElement | null;
    let nextTarget: HTMLInputElement | null = document.getElementById(
      nextInputId.toString()
    ) as HTMLInputElement | null;

    if (!target) return;
    if (currentInputId == "fullName") {
      if (!this.isValidName(target.value)) {
        target.classList.add("error");
        this.displayErrorMsg("nameError");
        return;
      }
      this.name = target.value;
      target.classList.remove("error");
      this.removeErrorMsg("nameError");
    }
    if (currentInputId == "email") {
      if (!this.isValidEmail(target.value)) {
        target.classList.add("error");
        this.displayErrorMsg("mailError");
        return;
      }
      this.mail = target.value;
      target.classList.remove("error");
      this.removeErrorMsg("mailError");
    }
    if (currentInputId == "password") {
      if (!this.isValidPass(target.value)) {
        target.classList.add("error");
        this.displayErrorMsg("passError");
        return;
      }
      this.password = target.value;
      target.classList.remove("error");
      this.removeErrorMsg("passError");
    }
    if (currentInputId == "confirm password") {
      if (!this.isConfirmPassValid(target.value)) {
        target.classList.add("error");
        this.displayErrorMsg("cnpError");
        return;
      }
      target.classList.remove("error");
      this.removeErrorMsg("cnpError");
    }
    if (currentInputId == "contact") {
      if (!this.isValidContact(target.value)) {
        target.classList.add("error");
        this.displayErrorMsg("contactError");
        return;
      }
      target.classList.remove("error");
      this.removeErrorMsg("contactError");
    }
    if (currentInputId == "gender") this.gender = target.value;
    let label: HTMLElement | null = document.getElementById("label-with-name");
    if (currentInputId == "fullName") {
      this.name = target.value;
      console.log("In Full Name");
      if (label) {
        label.innerText = `Hi ${this.name}, Can I get your ${nextInputId}.`;
        label.classList.toggle("hide");
        label.style.display = "block";
      }
    } else if (nextInputId != "empSubmit" && label) {
      label.innerText = `Please enter your ${nextInputId}`;
    } else {
      if (label) label.innerText = "";
    }
    target.classList.toggle("hide");
    if (nextTarget) nextTarget.classList.toggle("hide");

    return false;
  };
}

var employee = new EmployeeDetails();
