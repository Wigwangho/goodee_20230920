router.get('/update', function(req, res, next) {
  res.render('index', { title: '회원정보 수정', pageName: 'users/update.ejs' });
});

//라우터 -> req - require. 
//이 형태를 통해 라우터로 불러올 수 있다
//익스프레스를 통해 관리됨
