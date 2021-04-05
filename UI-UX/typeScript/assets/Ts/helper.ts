

class Helper{

//handle the submit task at the end of the form
handleSubmit=(currentFormId:String,nextFormId:String)=>{
    let cForm:HTMLElement|null = document.getElementById(currentFormId.toString());
    let nForm:HTMLElement|null = document.getElementById(nextFormId.toString());
    if(cForm) cForm.style.display = 'none';
    if(nForm) nForm.style.display = 'block';

}
}

var helper = new Helper();