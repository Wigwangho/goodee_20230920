$(frm).on('submit', async (event) => {
    console.log('글수정 클릭');
    event.preventDefault(); //새로고침 사이드이펙트 발동되는 걸 막음
    $("#modal-confirm .modal-body").html("수정된 정보를 저장하시겠습니까?");
    $("#modal-confirm").modal("show");
    //모달창에서 예(btn-primary)버튼을 눌렀을 때 이벤트 감지되고 실행문 진행되는 거니까
    //즉 외부에서 호출되는 함수가 아니니까  또 다른게는 onclick이벤트 핸들러의 콜백함수이라서
    //즉 내부에서 호출되고 끝나는 거니까 호이스팅 함수일 필요가 없다.
    let title = $(frm.title).val();
    let body = $(frm.body).val();
    $("#modal-confirm").on("click", ".btn-primary", async () => {//수정하기 처리에 대한 콜백
        await setDoc(doc(db, `board/${id}`),{
            ...row, title,  body
        });
        //성공하면 목록페이지로 간다
        location.href = "/board";
    });//end of 모달창에서 예 버튼 눌렀을 때 이벤트 처리하기


          //모달 사용법 $("#modal-confirm .modal-body").html("수정된 정보를 저장하시겠습니까?");
          //같은 폴더 내 modal-confirm 파일이 있어야 함
