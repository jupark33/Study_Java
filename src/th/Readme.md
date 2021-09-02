
Sync Async
Blocking Non-Blocking

Sync는 return을 사용함

Sync Blocking
호출하는 측에서는 return 받기 전에는 다른 일을 할 수 없다.

Sync Non-Blocking
호출받는 측에서 (거의) 바로 리턴한다. 호출받는 측에서는 일을 시작한다.
호출하는 측에서 일이 끝났는지 물어본다. 호출받는 측에서는 (거의) 바로 리턴한다. (완료 또는 미완)
호출하는 측에서 일이 끝났는지 물어본다. 호출받는 측에서는 (거의) 바로 리턴한다. (완료 또는 미완)
완료를 리턴 받을 때까지 반복한다.

/////////////////////////
Async는 Callback을 사용함.
호출하는 측에서 호출받는 측으로 Callback 함수이름을 알려준다.

Async Blocking
호출하는 측에서는 Callback 이 실행되기 전에는 다른 일을 하지 못한다.

Async Non-Blockiing
호출받는 측에서 (거의) 바로 리턴하고, 작업이 끝나면 Callback 함수를 호출 해준다.
따라서 호출하는 측에서 다른 일을 할 수 있다. (바로 리턴 받으므로)
 
