let coll:Element[] = Array.from(document.getElementsByClassName("collapsible"));

for (let i = 0; i < coll.length; i++) {
    coll[i].addEventListener("click", ()=> {
        coll[i].classList.toggle("active");
        var content:HTMLElement|null = coll[i].nextElementSibling as HTMLElement|null;
        if(content == null) return;
        if (content.style.display === "block") {
            content.style.display = "none";
        } else {
            content.style.display = "block";
        }
    });
}