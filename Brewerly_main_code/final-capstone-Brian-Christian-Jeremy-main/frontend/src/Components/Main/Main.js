import {Component} from 'react'
import {Switch, Route, Redirect, Link} from 'react-router-dom'
import Login from '../Login/Login'
import Register from '../Register/Register'
import Home from '../Home/Home'
import {addToken, deleteUser} from '../../Redux/actionCreators'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'

const mapStateToProps = state => {
    return {
        token: state.token,
        user: state.user
    }
}

const mapDispatchToProps = (dispatch) => ({
    addToken: () => { dispatch(addToken()) },
    deleteUser: () => { dispatch(deleteUser())}
});

class Main extends Component {
    constructor(props){
        super(props);
    }

    handleLogout = () => {
        this.props.addToken("")
        this.props.deleteUser()
    }

    render(){
        return(
            <div>
                {this.props.token.token !== undefined ?
                    <div className="header">
                        <div className="logo-wrapper"><h4>Brewerly</h4></div>
                        <div className="nav">
                            <Link to='/home'>Home  </Link>
                            <Link to='/login' onClick={this.handleLogout}>Logout</Link> 
                            <Redirect to='/home'/>

                        </div> 
                        </div>
                    : 
                       
                    <div className="header">
                    
                    <div className="logo-wrapper"><h4>Brewerly</h4></div>
                    <div className="nav">
                    <Link to='/login'>Login  </Link>
                    </div>
                    </div>
             }
                     
                       
            
                <Switch>
                    <Route path='/login' component={() => <Login/>}/>
                    <Route path='/register'component={() => <Register/>}/>
                    <Route path='/home' component={this.props.token.token !== undefined ? () => <Home/> : null}/>
                    <Redirect to='/login'/>
                </Switch>  
            </div>
        )
    }
} 

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Main));