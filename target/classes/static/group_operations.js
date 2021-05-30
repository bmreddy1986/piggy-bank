var req = new XMLHttpRequest();
req.open('GET', 'http://localhost:8080/group/10001', true);
req.onload = function () {  
  var group = JSON.parse(this.response);
  
  //var id = document.createElement("id");
  //id.innerHTML = group.id;
  //document.getElementById("root").appendChild(id);
  
  console.log(Object.keys(group).length);
  
  Object.keys(group).forEach(function(key){
    var value = group[key];
    document.getElementById("root").innerHTML += key;
    document.getElementById("root").innerHTML += ':';
    document.getElementById("root").innerHTML += value;
    document.getElementById("root").innerHTML += '<br>';
    //console.log(key + ':' + value );
});

}
req.send();