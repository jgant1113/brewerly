import * as ActionTypes from './actionTypes';

const initialState = {
    id: null,
    username: "",
    authorities: [],
};

export const User = (state = initialState, action) => {
    switch (action.type) {
        case ActionTypes.ADD_USER:
            return { ...state, 
                id: action.payload.id, 
                username: action.payload.username, 
                authorities: action.payload.authorities }
        
        case ActionTypes.DELETE_USER:
            return { ...state, id: null, username: "", authorities: [] }

        default:
            return state;
    }
}





  
