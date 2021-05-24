var req = new XMLHttpRequest()
req.open('GET', 'http://localhost:8080/group/GRP_1001', true)
req.onload = function () {  
  // Begin accessing JSON data here
  var data = JSON.parse(this.response)
  
  console.log(data.id)
  console.log(data.name)
  console.log(data.roi)
  console.log(data.deposit)
}
req.send()