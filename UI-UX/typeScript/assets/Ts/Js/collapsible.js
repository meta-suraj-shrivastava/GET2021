var coll = Array.from(document.getElementsByClassName("collapsible"));
var _loop_1 = function (i) {
    coll[i].addEventListener("click", function () {
        coll[i].classList.toggle("active");
        var content = coll[i].nextElementSibling;
        if (content == null)
            return;
        if (content.style.display === "block") {
            content.style.display = "none";
        }
        else {
            content.style.display = "block";
        }
    });
};
for (var i = 0; i < coll.length; i++) {
    _loop_1(i);
}
