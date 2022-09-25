import * as ActionTypes from './actionTypes'

export const addToken = (token) => ({
    type: ActionTypes.ADD_TOKEN,
    payload: token
});

export const addUser = (user) => ({
    type: ActionTypes.ADD_USER,
    payload: user
})

export const deleteUser = () => ({
    type: ActionTypes.DELETE_USER
})

export const addProfile = (profile) => ({
    type: ActionTypes.ADD_PROFILE,
    payload: profile
})

export const deleteProfile = () => ({
    type: ActionTypes.DELETE_PROFILE
})