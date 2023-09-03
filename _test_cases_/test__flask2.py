from flask import Flask
import unittest
from flask import current_app
#import your own app 
from your_app import login

class TestWebApp(unittest.TestCase): 
    def setUp(self): 
        self.app = login() 
        self.appct = self.app.app_content() 
        self.appctx.push() 
    def validate_user(username): 
        if not isinstance(username, str): 
            return False
        if username.isalpha(): 
            return True
        else: 
            return False
    def login_(client, username, password): 
        return client.post('/login_', data=dict(
            username = username, 
            password = password 
        ), follow_redirects = True)
    def logout(client): 
        return client.get('/logout', follow_redirects = True) 
    
    def test_login_logout(client, login, logout): 
        rv = login(client, Flask.app.config['USERNAME'], Flask.app.config['PASSWORD'])
        assert b'You were logged in successfully' in rv.data
        rv = logout(client)
        assert b"You were logged out successfully" in rv.data
        rv = login(client, Flask.app.config['USERNAME'] + 'x', Flask.app.config['PASSWORD'])
        assert b'Your username is invalid' in rv.data
        rv = logout(client, Flask.app.config['USERNAME'], Flask.app.config['PASSWORD'] + 'x')
        assert b'Your password is invalid' in rv.data 
    
if __name__ == "__main__":  
    unittest.main()
    
