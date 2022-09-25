import axios from 'axios'
import {Component} from 'react'
import {Link} from 'react-router-dom'
import { baseUrl } from '../../Shared/baseUrl'
import { withRouter } from 'react-router-dom'


class Register extends Component{

    constructor(props){
        super(props);
        this.state = {
            username: '',
            password: '',
            confirmPassword: '',
            role: 'Lover'
        }
        this.onChangeValue = this.onChangeValue.bind(this);
    }

    handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    onChangeValue(event) {
        if(event.target.value === 'Lover'){
            this.setState({
                role: 'Lover'
            })
        }
        else this.setState({
            role: 'Brewer'
        })
    }

    handleSubmit = () => {
        const data = {username: this.state.username, password: this.state.password, 
            confirmPassword: this.state.confirmPassword, role: this.state.role}
        const profile = {username: this.state.username, profileType: this.state.role}
        if(this.state.password === this.state.confirmPassword){

             fetch(baseUrl+'/profile/add', {
                 method: 'POST',
                 headers: {
                     'Content-Type': 'application/json',
                 },
                 body: JSON.stringify(profile),
                 })

                 .then((response) => response.json())
                 .then((result) => console.log('Success', result))
                 .catch((error) => console.error('Error:', error))

            axios.post(baseUrl + "/register", data)
            this.props.history.push("/")
        }else{
            alert("Password and Confirm Password must match!!!")
        }
    }
    
    render(){
        return(
            <div className="Register">
                <div className="form">
                <div className="form-inner">
                <h2>Create Account</h2>
                 {/* ERROR!!! */}

                <div className="form-group">
                    <label className="input-label" htmlFor='username'>Username</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        class="form-control"
                        placeholder="Username"
                        v-model="user.username"
                        onChange={this.handleInputChange}
                        required />
                    </div>

                    <div className="form-group">
                    <label className="input-label" htmlFor="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        class="form-control"
                        placeholder="Password"
                        v-model="user.password"
                        onChange={this.handleInputChange}
                        required />
                    </div>

                    <div className="form-group">
                        <label className="input-label"  htmlFor="password-confirm">Confirm Password</label>
                        <input
                        type="password"
                        id="password-confirm"
                        name="confirmPassword"
                        class="form-control"
                        placeholder="Confirm Password"
                        v-model="user.password"
                        onChange={this.handleInputChange}
                        required
                    />
                    </div>
                    
                    <div className="user-type-reg" onChange={this.onChangeValue}>
                        <p>I am a:</p>
                        <label className="radio-label" htmlFor='lover'>Beer Lover</label>
                        <input className="reg-radio"
                            type = 'radio'
                            id='lover'
                            name='role'
                            placeholder='I am a Beer Lover'
                            value = 'Lover'
                            defaultChecked 
                        />
                        <label className="radio-label" htmlFor='brewer'>Brewer</label>
                        <input className="reg-radio"
                            type = 'radio'
                            id='brewer'
                            name='role'
                            placeholder='I am a Brewer'
                            value='Brewer' 
                        />
                    </div>
                    <input  type="submit" onClick={this.handleSubmit} value="Register" /> 
                    <p>Already have an account? <Link to="/login">Login Here!</Link></p>
                    </div>
                </div>
                </div>
       
        )
    }
}

export default withRouter(Register);