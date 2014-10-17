function setskl() {
    var h = document.getElementById('cnt');
    if (h != null) {
        var s = h.innerHTML.toString();
        var c = parseInt(s.substring(0, s.indexOf(' ')));
        if (c == 1) h.innerHTML += "";
        else if (c < 5 && c > 1) h.innerHTML += "а";
        else h.innerHTML = h.innerHTML += "ов";
    }
}