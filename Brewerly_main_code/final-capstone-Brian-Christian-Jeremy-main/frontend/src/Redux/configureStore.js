import { createStore, combineReducers, applyMiddleware, compose} from 'redux'
import thunk from 'redux-thunk'
import {Token} from './token'
import {User} from './user'
import {Profile} from './profile'

export const ConfigureStore = () => {

    const rootReducer = combineReducers({
        token: Token,
        user: User,
        profile: Profile
    })
       
    const store = createStore(
        rootReducer,
        compose(
          applyMiddleware(thunk),
          window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
        )
      );
    
      

    return store;
}