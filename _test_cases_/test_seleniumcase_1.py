from selenium import webdriver
from selenium.webdriver.common.keys import keys 
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By 
import unittest

class TestLog(unittest.TestCase): 
    #creating a headless chrome browse
    def setUp(self): 
        op = webdriver.ChromeOptions()
        op.add_argument('headless')
    def test_search(self): 
        self.driver.get("https://www.python.org")
        element = self.driver.findElement(By.XPATH("#anylink"))
        element.submit()
        exp_url = "https://example.com"
        assert exp_url == self.driver.current_url 

    def tearDown(self):
        self.driver.close()

    if __name__ == "__main__": 
        unittest.main()


