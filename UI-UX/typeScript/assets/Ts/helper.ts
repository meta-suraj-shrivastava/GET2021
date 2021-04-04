

interface helperInterface {
    getParent(node:HTMLElement):HTMLElement;
    getSibling(node:HTMLElement):HTMLElement;
    handleSubmit():null;

}

class Helper implements helperInterface{
//return the parent of the current node
getParent(currentNode:HTMLElement){
    var parent = currentNode;
    while(parent.nodeName != 'DIV'){
        parent = parent.parentNode as HTMLElement;
    }
    return parent;

}

//return the next sibling of the current node
getSiblig(currentNode:HTMLElement){
    let sibling:HTMLElement = currentNode.nextSibling as HTMLElement;
    while(sibling.nodeName != 'DIV' && sibling.nodeName != 'INPUT' && sibling.nodeName != 'BUTTON' && sibling.nodeName != 'TEXTAREA'){
        sibling = sibling.nextSibling as HTMLElement;
        if(sibling == null) return null;
    }
    return sibling;
}


//handle the submit task at the end of the form
handleSubmit(input:Event){
    var t = input.target;
    t.
    var parent = input.
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
}