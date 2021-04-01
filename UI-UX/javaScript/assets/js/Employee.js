
//All the validation related to the Employee form can be done using this class object

class EmployeeDetails{

    //return true if password valiation  get success
    //@param - password
    isValidPass(password){
        var regex = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}/;
        return regex.test(password);
    }

    //return true if name valiation  get success
    //@param - name
    isValidName(name){
        var regex = /^[A-Za-z]{2,}$/
        return regex.test(name);
    }
    
    //return true if conf password valiation  get success
    //@param - password
    isConfirmPassValid(password){
        return this.password == password;
    }

    //return true if contact valiation  get success
    //@param - contact
    isValidContact(contact){
        var regex = /^[\d]{8,10}$/
        return regex.test(contact);
    }

    //return true if emoal valiation  get success
    //@param - email
    isValidEmail(email){
        var regEx = /^[a-zA-Z0-9]+@[a-z]{4,}.[a-z]{2,}(.[a-z]{2,4})?$/;
        return regEx.test(email);
    }

      //It will handle the press events occuring while entering employee details
    handlePress(event){
        if (!event) event = window.event;
        var keyCode = event.code || event.key;
        if (keyCode == 'Enter'){
            var currentNode = event.target;
            if(currentNode.id == 'fullName'){
                if(!this.isValidName(currentNode.value)){
                    currentNode.classList.add('error');
                    document.getElementById('nameError').style.display="block";
                    return;
                }
                this.name = currentNode.value;
                currentNode.classList.remove('error');
                document.getElementById('nameError').style.display = "none";
            }
            if(currentNode.id == 'email'){
                if(!this.isValidEmail(currentNode.value)){
                    currentNode.classList.add('error');
                    document.getElementById('mailError').style.display="block";
                    return;
                }
                this.mail = currentNode.value;
                currentNode.classList.remove('error');
                document.getElementById('mailError').style.display = "none";
            }
            if(currentNode.id == 'password'){
                if(!this.isValidPass(currentNode.value)){
                    currentNode.classList.add('error');
                    document.getElementById('passError').style.display="block";
                    return;
                }
                this.password = currentNode.value;
                currentNode.classList.remove('error');
                document.getElementById('passError').style.display = "none";
            }
            if(currentNode.id == 'confirm password'){
                if(!this.isConfirmPassValid(currentNode.value)){
                    currentNode.classList.add('error');
                    document.getElementById('cnpError').style.display="block";
                    return;
                }
                currentNode.classList.remove('error');
                document.getElementById('cnpError').style.display = "none"; 
            }
            if(currentNode.id == 'contact'){
                if(!this.isValidContact(currentNode.value)){
                    currentNode.classList.add('error');
                    document.getElementById('contactError').style.display="block";
                    return;
                }
                currentNode.classList.remove('error');
                document.getElementById('contactError').style.display = "none";  
            }
            if(currentNode.name == 'gender') this.gender = currentNode.value;
            var parent;
            var sibling = getSiblig(currentNode);
            if(sibling == null){
                parent =  getParent(currentNode);
                parent.classList.toggle('hide');
                sibling = getSiblig(parent);
            }
            var label = document.getElementById('label-with-name');
            if(currentNode.id == 'fullName'){
                this.name = currentNode.value;
                console.log();
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
            currentNode.classList.toggle('hide');
            sibling.classList.toggle('hide');
    
    
          return false;
        }
    }
}