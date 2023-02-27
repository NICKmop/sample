// 즉시 실행 함수 : (function(){})();
(function(){
    const spanEl = document.querySelector("main h2 span");
    const txtArr = ['Web Publisher', 'Front-End Developer', 'Wen UI Designer' , 'UX Designer', 'Back-End Dev'];
    let index = 0;
    let currentTxt = txtArr[index].split("");
    // function writeText() {
    //     console.log(spanEl.textContent)
        
    //     setTimeout(function () {
    //         spanEl.textContent = 'test'
    //     }, 3000);
    // }
    function writeText() {
        spanEl.textContent += currentTxt.shift();
        if(currentTxt.length !== 0){
            setTimeout(writeText, Math.floor(Math.random * 100));
        }else{
            currentTxt = spanEl.textContent.split("");
            setTimeout(deleteTxt,3000);
            // console.log("currentTxt : " , currentTxt);
        }
    }
    function deleteTxt() {
        currentTxt.pop();
        spanEl.textContent = currentTxt.join("");; 
        if(currentTxt.length !== 0){
            setTimeout(deleteTxt, Math.floor(Math.random * 100));
        }else{
            index = (index + 1) % txtArr.length;
            currentTxt = txtArr[index].split("");
            writeText();
        }
    }
    writeText();
})();

(function () {
    // 수직 스크롤이 발생하면 header 태그에 active 클래스 추가.
    const headerEl = document.querySelector("header");
    window.addEventListener("scroll", function () {
        // scrollCheck();
        // scroll 이벤트 최적화 해주는 함수..
        this.requestAnimationFrame(scrollCheck);
    })
    function scrollCheck() {
        const browserScrollY = window.scrollY ? window.scrollY : window.pageYOffset;
        if(browserScrollY > 0){
            headerEl.classList.add('active')
        }else{
            headerEl.classList.remove('active');
        }
        console.log("scroll");
    }
})();

(function () {
    const animationMove = function (selector) {
        const target = document.querySelector(selector);
        // y축의 스크롤 값.
        const browserScrollY = window.pageYOffset;
        const targetScrollY = target.getBoundingClientRect().top + browserScrollY;
        window.scrollTo({top: targetScrollY, behavior:'smooth'});
    }
    // "[data-animation-scroll='true'] 이 값이 트루인 버튼만 찾아 준다.
    const scrollMoveEl = document.querySelectorAll("[data-animation-scroll='true']");
    console.log(scrollMoveEl);
    for (let index = 0; index < scrollMoveEl.length; index++) {
        scrollMoveEl[index].addEventListener("click",function (e) {
            animationMove(this.dataset.target)
        })
    }
})();
// ajax Test
$(function(){
        $('#submit').on("click",function () {
//          let form1 = $("#form").serialize();
            let form1 = "hello String";

            $.ajax({
                type: "post",
//                type: "get",
                url: "/index",
                data: {
                    ids : [1,2,3]
                },
                dataType: 'json',
//                dataType: 'text',
                success: function (data) {
                    alert("success");
                    console.log(data);
                },
                error: function (request, status, error) {
                    console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);

                }
            });

        });
    });