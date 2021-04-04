
//All the validation related to the Employee form can be done using this class object
interface EmpInterface{
    password:String;
    name:String;
    mail:String;
    gender:String;
    helper:Helper;
}


class EmployeeDetails implements EmpInterface{
    password: String;
    name: String;
    mail: String;
    gender: String;
    helper: Helper;
    //return true if password valiation  get success
    //@param - password
    constructor(){
        this.helper = new Helper();
    }
   
    isValidPass(password:String){
        let regex = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}/;
        return regex.test(password.toString());
    }

    //return true if name valiation  get success
    //@param - name
    isValidName(name:String){
        let regex = /^[A-Za-z]{2,}$/
        return regex.test(name.toString());
    }
    
    //return true if conf password valiation  get success
    //@param - password
    isConfirmPassValid(password:String){
        return this.password.toString() == password.toString();
    }

    //return true if contact valiation  get success
    //@param - contact
    isValidContact(contact:String){
        let regex = /^[\d]{8,10}$/
        return regex.test(contact.toString());
    }

    //return true if emoal valiation  get success
    //@param - email
    isValidEmail(email:String){
        let regEx = /^[a-zA-Z0-9]+@[a-z]{4,}.[a-z]{2,}(.[a-z]{2,4})?$/;
        return regEx.test(email.toString());
    }

      //It will handle the press events occuring while entering employee details
    handlePress(keyboard:KeyboardEvent,input:HTMLInputElement){
        if (!keyboard) keyboard = window.undefined;
        let keyCode = keyboard.code;
        if (keyCode == 'Enter'){
            if(input.id == 'fullName'){
                if(!this.isValidName(input.value)){
                    input.classList.add('error');
                    document.getElementById('nameError').style.display="block";
                    return;
                }
                this.name = input.value;
                input.classList.remove('error');
                document.getElementById('nameError').style.display = "none";
            }
            if(input.id == 'email'){
                if(!this.isValidEmail(input.value)){
                    input.classList.add('error');
                    document.getElementById('mailError').style.display="block";
                    return;
                }
                this.mail = input.value;
                input.classList.remove('error');
                document.getElementById('mailError').style.display = "none";
            }
            if(input.id == 'password'){
                if(!this.isValidPass(input.value)){
                    input.classList.add('error');
                    document.getElementById('passError').style.display="block";
                    return;
                }
                this.password = input.value;
                input.classList.remove('error');
                document.getElementById('passError').style.display = "none";
            }
            if(input.id == 'confirm password'){
                if(!this.isConfirmPassValid(input.value)){
                    input.classList.add('error');
                    document.getElementById('cnpError').style.display="block";
                    return;
                }
                input.classList.remove('error');
                document.getElementById('cnpError').style.display = "none"; 
            }
            if(input.id == 'contact'){
                if(!this.isValidContact(input.value)){
                    input.classList.add('error');
                    document.getElementById('contactError').style.display="block";
                    return;
                }
                input.classList.remove('error');
                document.getElementById('contactError').style.display = "none";  
            }
            if(input.name == 'gender') this.gender = input.value;
            let parent:HTMLElement;
            let sibling:HTMLElement = this.helper.getSiblig(input);
            if(sibling == null){
                parent =  this.helper.getParent(input);
                parent.classList.toggle('hide');
                sibling = this.helper.getSiblig(parent);
            }
            let label = document.getElementById('label-with-name');
            if(input.id == 'fullName'){
                this.name = input.value;
                console.log("In Full Name");
                label.innerText = `Hi ${this.name}, Can I get your ${sibling.id}.`
                label.classList.toggle('hide');
                label.style.display="block";
            }
            else if(sibling.nodeName!='BUTTON'){
                label.innerText = `Please enter your ${sibling.id}` 
            }
            else{
                label.innerText ="";
            }
            input.classList.toggle('hide');
            sibling.classList.toggle('hide');
    
    
          return false;
        }
    }
}