import * as ActionTypes from './actionTypes';

//Took out a username field from state and it's updates in the returns
export const Profile = (state = {
    profileType: ''}, action) => {
        switch (action.type) {
            case ActionTypes.ADD_PROFILE:
            return { ...state,  
                profileType: action.payload }
            case ActionTypes.DELETE_USER:
            return { ...state, profileType: '' }
            default:
            return state;
    }
}