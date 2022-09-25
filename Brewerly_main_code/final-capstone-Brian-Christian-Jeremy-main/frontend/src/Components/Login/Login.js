import { Component } from 'react'
import {Link} from 'react-router-dom'
import {connect} from 'react-redux'
import {withRouter} from 'react-router-dom'
import {addProfile, addToken, addUser} from '../../Redux/actionCreators'
import {baseUrl} from '../../Shared/baseUrl'
import axios from 'axios'
const mapDispatchToProps = (dispatch) => ({
    addToken: () =>  dispatch(addToken()),
    addUser: () => dispatch(addUser()),
    addProfile: () => dispatch(addProfile())
});

class Login extends Component {

    constructor(props){
        super(props);
        this.state = {
            username: '',
            password: ''
        }
        this.handleInputChange = this.handleInputChange.bind(this);
    }
    handleLogin = async () => {
        const data = { username: this.state.username, password: this.state.password };
        const userWithToken = await axios.post(baseUrl + '/login', data)
        const userProfile = await axios.get(baseUrl  + 
            '/profile/' + data.username, data.username)

        this.props.dispatch(addToken(userWithToken.data.token));
        this.props.dispatch(addUser(userWithToken.data.user));
        this.props.dispatch(addProfile(userProfile.data))

        console.log(userProfile);
        if(userProfile.data === ''){
            alert('This account does not exist.')
        }
    }

    handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render(){
        return(
            <div className="Login">
                <div className="form">
            <div className="form-inner">
                <h2>Login</h2>
                <div className="form-group">
                <label class="sr-only">Username</label>
                <input
                    type="text"
                    id="username"
                    name="username"
                    class="form-control"
                    placeholder="Username"
                    v-model="user.username"
                    onChange={this.handleInputChange}
                    required
                />
                </div>
                <label class="sr-only">Password</label>
                <div className="form-group">
                <input
                    type="password"
                    id="password"
                    name="password"
                    class="form-control"
                    placeholder="Password"
                    v-model="user.password"
                    onChange={this.handleInputChange}
                    required
                />
                </div>
                <Link to="/register">Need an account?</Link>
                <input type="submit" onClick={this.handleLogin} value="Login" />
            </div>
            </div>
            </div>
        )
    }
}


export default withRouter(connect(mapDispatchToProps)(Login));




// const mapDispatchToProps = (dispatch) => ({
//     addToken: () =>  dispatch(addToken()),
//     addUser: () => dispatch(addUser()) 
// });

// class Login extends Component {
    
//     constructor(props){
//         super(props);
//         this.state = {
//             username: '',
//             password: ''
//         }
//         this.handleInputChange = this.handleInputChange.bind(this);
//     }
    
    

//     handleLogin = async () => {
//         const data = { username: this.state.username, password: this.state.password }
        
//         const userWithToken = await axios.post(baseUrl + '/login', data)
//         console.log(userWithToken);
//         await this.props.dispatch(addToken(userWithToken.data.token))
//         await this.props.dispatch(addUser(userWithToken.data.user));
//         <Redirect to="/home"/>
   
//     }

//     handleInputChange = (event) => {
//         event.preventDefault()
//         this.setState({
//             [event.target.name]: event.target.value
//         })
//     }

//     render(){
//         return(
//           <div className="Login">
//            <form>
//             <div className="form-inner">
//                 <h2>Login</h2>
//                 {/* ERROR!!! */}
               
//                 <div className="form-group">
//                     <label  className="input-label" htmlFor="username" >Username</label>
//                         <input
//                             type="text"
//                             id="username"
//                             name="username"
//                             className="form-control"
//                             placeholder="Username"
//                             v-model="user.username"
//                             onChange={this.handleInputChange}
//                             required/>
//                 </div>
             
//                 <div className="form-group">
//                     <label className="input-label" htmlFor="password" >Password</label>
//                         <input
//                             type="password"
//                             id="password"
//                             name="password"
//                             className="form-control"
//                             placeholder="Password"
//                             v-model="user.password"
//                             onChange={this.handleInputChange}
//                             required />
//                 </div>

//                     <input  
//                         type="submit" 
//                         onClick={this.handleLogin} 
//                         value="LOGIN" />   
                    
//                     <p>No account? <Link to="/register">Click Here!
//                         </Link>
//                     </p>
//             </div>
//              </form>
//         </div>
            
//         )
//     }
// }

// export default withRouter(connect(mapDispatchToProps)(Login));