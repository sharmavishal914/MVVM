package com.vishal.kotlinmvvm.ui.home.list


import com.vishal.kotlinmvvm.data.local.SessionManager
import com.vishal.kotlinmvvm.data.remote.RequestInterface
import com.vishal.kotlinmvvm.ui.base.BaseViewModel


class ListViewModel(sessionManager: SessionManager, requestInterface: RequestInterface) : BaseViewModel<ListNavigator>(sessionManager, requestInterface)