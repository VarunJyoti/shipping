var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});


/* GET Userlist page. */
router.get('/userlist', function(req, res) {
    var db = req.db;
    var collection = db.get('users');
    collection.find({},{},function(e,docs){
        res.json(docs);
    });
});


/* GET user by email. 
Params
	- email STRING
*/
router.get('/get_user', function(req, res) {
    var db = req.db;
    var collection = db.get('users');

    var userEmail = req.params.email;

    collection.find({email:userEmail},function(e,docs){
        res.json(docs);
    });
});


/* POST 
Params:
	-username STRING
	-password STRING
	-email	STRING
	-permissions ARRAY eg "superadmin","company","supervisor","enduser"
*/
router.post('/add_user', function(req, res) {

  var db = req.db;
  var collection = db.get('users');
  
  var userName = req.body.username;
  var email = req.body.email;
  var password = req.body.password;
  var permissions = req.body.permissions;

  var userJsonObj = {
	"name": userName,
	"email": email,
	"password": password,
	"created_on": new Date().toISOString().replace(/T/, ' ').replace(/\..+/, ''),
	"modified_on": new Date().toISOString().replace(/T/, ' ').replace(/\..+/, ''),
	"status": 1,
	"permissions": [permissions]
}

  collection.insert(userJsonObj, function(err, docs) {
    if (err) {
      res.json({"error":err});
    }
    else {
      res.json(docs);
    }
  });

});

module.exports = router;
