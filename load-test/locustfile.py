from locust import HttpUser, task, between

import random

class UserAPITester(HttpUser):


    @task
    # def payments_test(self):
    #     user_id = 100
    #     self.client.get(f"/payments/{user_id}")

    @task
    def users_test(self):
        # user_id = random.randrange(1, 10)
        user_id = 100
        self.client.get(f"/users/{user_id}")


        