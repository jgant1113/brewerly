import * as ActionTypes from './actionTypes';
const initialState = {
    token: undefined,
  };
export const Token = (state = initialState, action) => {
    switch (action.type) {
        case ActionTypes.ADD_TOKEN:
            return { ...state, token: action.payload }
        
        default:
            return state;
    }
}



