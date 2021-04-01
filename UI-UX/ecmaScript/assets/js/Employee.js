class EmployeeDetails{
    constructor(){
        let name,mail,password,gender;
    }
    isValidPass=(password)=>{
        let regex = /(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}/;
        return regex.test(password);
    }
    isValidName=(name)=>{
        let regex = /^[A-Za-z]{2,}$/
        return regex.test(name);
    }
    
    isConfirmPassValid=(password)=>{
        return this.password == password;
    }
    isValidContact=(contact)=>{
        let regex = /^[\d]{8,10}$/
        return regex.test(contact);
    }

    isValidEmail=(email)=>{
        let regEx = /^[a-zA-Z0-9]+@[a-z]{4,}.[a-z]{2,}(.[a-z]{2,4})?$/;
        console.log("Email val");
        return regEx.test(email);
    }
    handlePress=(event)=>{
        if (!event) event = window.event;
        let keyCode = event.code || event.key;
        if (keyCode == 'Enter'){
            let currentNode = event.target;
            if(currentNode.id == 'fullName'){
                if(!this.isValidName(currentNode.value)){
                    console.log("Not valid name");
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
                    console.log( document.getElementById('mailError'));
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
            let parent;
            let sibling = getSiblig(currentNode);
            if(sibling == null){
                parent =  getParent(currentNode);
                parent.classList.toggle('hide');
                sibling = getSiblig(parent);
            }
            let label = document.getElementById('label-with-name');
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