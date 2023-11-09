import {
  getAuth,
  GithubAuthProvider,
  GoogleAuthProvider,
  signInWithPopup
} from 'https://www.gstatic.com/firebasejs/10.5.2/firebase-auth.js';
class AuthLogic {
  constructor() {
    this.auth = getAuth();
    this.gitProvider = new GithubAuthProvider();
    this.googleProvider = new GoogleAuthProvider();
  }
  getUserAuth = () => {
    return this.auth;
  };

  getGoogleAuthProvider = () => {
    return this.GoogleProvider;
  };
}

const params = {
  uid: '1223222',
  email: 'kaaa@hot.com',
};

// end of AuthLogic
//import {AuthLogic} from "./service/authLogic.js"
//뒤에 default 가 있으면 좌중괄호 우중괄호 금지

export default AuthLogic;

//import {loginGoogle, loginKakao, logout} from "./service/authLogic.js"
//클래스의 주소번지없이(authLogic.loginGoogle) 호출하고 사용할 수 있도록(어디서? html, js) 함수 선언 앞에 export를 붙여준다

//v파라미터로 auth를 넣어줘야 signOut() 호출이 가능하다
//이때 에러가 발생(인증 토큰 없음 -> 우리 사용자가 아님 -> 너 url로 접근하려는 거야? -> 공격이니??) 하면 
//catch에 잡히게 된다 ->잡히면 reject에서 처리함 -> 인터셉트 발생
export const logout = (auth)=>{
  return new Promise((resolve, reject)=>{
    auth.signOut().catch(e=>reject(alert(e+": 로그아웃 에러 발생")))
    //원래 서비스에서는 세션에서 관장되는 영역이다 -구글 서버 측에서 담당한다 - >signOut() 에서 행해짐
    localStorage.removeItem('uid')//uid 보유 -> 구글 서버로부터 정상적으로 토큰 발행받은 상태 - 그 정보를 삭제하다
    localStorage.removeItem('email')
    localStorage.removeItem('displayName')
    resolve()})
}
  //비동기체 -> 구글 서버를 사용하고 있으므로 기다림이 필요
  //구글 서버 등 공사다망한 함수, 객체를 사용할 시
  //지금 바쁜 일이 있어서 있다가 갈게 -> promise
  //resolve -> 가능해
  //reject -> 안 될 것 같아...
  export const loginGoogle = (auth, googleProvider) => {
    console.log('loginGoogle호출 성공');
    console.log(googleProvider);
    return new Promise((resolve, reject) => {
      signInWithPopup(auth, googleProvider)
      .then((result) => {
        console.log(result);//object Object - 안보임 - uid, displayName-realname, email
        console.log(JSON.stringify(result));
        const user = result.user;
        localStorage.setItem("uid", user.uid);
        localStorage.setItem("displayName", user['displayName']);
        localStorage.setItem('email', user.email);
        resolve(user)
      }).catch((error) => reject(error));
    });
  }; //end of loginGoogle

export const loginEmail = (params) => {
  return new Promise((resolve, reject) => {
    signInWithEmailAndPassword(auth, email, password)
      .then((result) => {})
      .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
      });
  }); //end of promise
}; //end of loginGoogle

export const loginKakao = (params) => {
    return new Promise((resolve, reject) => {
      try {
        const response = axios({
          method: 'get',
          url: '카카오토큰을 받아올 URL주소 -카카오개발자 센터 긁어옴',
          params: params,
        });
        console.log(response);
        resolve(response);
      } catch (error) {
        reject(error);
      }
    });
  }; //end of loginKakao
