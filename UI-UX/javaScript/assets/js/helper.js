function getParent(currentNode){
    var parent = currentNode;
    while(parent.nodeName != 'DIV'){
        parent = parent.parentNode;
    }
    return parent;

}
function getSiblig(currentNode){
    var sibling = currentNode.nextSibling;
    while(sibling.nodeName != 'DIV' && sibling.nodeName != 'INPUT' && sibling.nodeName != 'BUTTON' && sibling.nodeName != 'TEXTAREA'){
        sibling = sibling.nextSibling;
        if(sibling == null) return null;
    }
    return sibling;
}


function handleSubmit(event){
    var parent = event.path[3];
    var center = parent.children[0];
    var content = center.children[1];
    content.style.display = 'none';
    if(parent.nextElementSibling==null){
        return
    }
    else{
        parent.nextElementSibling.children[0].children[1].style.display="block";
    }

}