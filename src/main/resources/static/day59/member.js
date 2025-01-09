
console.log('member.js open')

// 1. signup 함수 
function signup(){ console.log('signup() open')
    //(1) HTML의 input의 DOM 가져오기 
    const midInput = document.querySelector('.midInput')
    const mpwdInput = document.querySelector('.mpwdInput')
    const mnameInput = document.querySelector('.mnameInput')
    const mphoneInput = document.querySelector('.mphoneInput')
    //(2) DOM의 VALUE 입력값 반환 
    const mid = midInput.value;
    const mpwd = mpwdInput.value;
    const mname = mnameInput.value;
    const mphone = mphoneInput.value;
    //(3) 여러개 데이터를 하나의 타입으로 묶어주기 = 객체화
    const info = { mid : mid , mpwd : mpwd , mname : mname , mphone : mphone } 
    //(4) fetch 
    const option = {
        method : 'POST' , 
        headers : { 'Content-Type' : 'application/json' },
        body : JSON.stringify( info )
    }
    fetch( '/signup.do' , option )
        .then( r => r.json() )
        .then( data => {console.log( data );
            //(5) 결과에 따른 화면 구성 
            if( data == true ){
                alert('회원가입 성공 했습니다.');
                // 회원가입 성공시 로그인페이지로 이동 
                location.href="/login"        // location.href="URL" : JS에서 페이지전환 함수
            }// if end 
            else{
                alert('회원가입 실패 했습니다.');
            }
        })
        .catch( e => { console.log(e); })
} // f end 



// 2. login 함수 