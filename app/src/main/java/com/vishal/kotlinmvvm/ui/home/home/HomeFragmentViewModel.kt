package com.vishal.chat.ui.home.home


import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import com.vishal.kotlinmvvm.ui.login.BaseViewModel


class HomeFragmentViewModel(sessionManager: SessionManager, requestInterface: RequestInterface) : BaseViewModel<HomeFragmentNavigator>(sessionManager, requestInterface) {

}
