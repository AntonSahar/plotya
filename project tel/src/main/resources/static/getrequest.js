$( document ).ready(
    function () {

        // GET REQUEST
        $(".getAllMessages").click(function (event) {
            event.preventDefault();
            ajaxGet();
        });

        // DO GET
        function ajaxGet() {
            $.ajax({
                type: "GET",
                url: window.location + "/users",
                data: {
                    ajaxid: 1
                },
                success: function (result) {
                    //console.log($('.getAllMessages h5')[2].innerText);
                    var count = $('.getAllMessages').length;
                    console.log(count);
                    if (result.msg == "Done")
                        $('#getResultDiv ul').empty();
                        var custList = "";
                        for(var x = 0;x < result.result.length-1;x++){
                            var user =result.result[x].firstName + " " + result.result[x].lastName;
//                            console.log(user);
                            for(var l = 0; l < count;l++){
                                var tmp = $('.getAllMessages h5')[l].innerText;
                                //console.log(tmp);
                                if(tmp==user){
                                    console.log("norm");
                                }
                            }
                        }
                },
                error: function (e) {
                    $("#getResultDiv").html("<strong>Error</strong>");
                    console.log("ERROR: ", e);
                }
            });
        }
    })
