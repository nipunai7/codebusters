import React, { Component } from "react";
import { Line } from "react-chartjs-2";

class Chart extends Component {
  constructor(props) {
    super(props);

    this.state = {
      options: {
        labels: this.props.stamps,
        datasets: [
          {
            label: this.props.type,
            data: this.props.temps,
            backgroundColor: "rgba(75,192,192,1)",
            borderColor: "rgba(0,0,0,1)"
          }
        ]
      }
    };
  }

  componentDidUpdate(prevProps) {
    const { temps, stamps, type } = this.props;
    if (prevProps.temps !== temps && prevProps.stamps !== stamps) {
      const options = { ...this.state.options };
      options.labels = stamps;
      options.datasets[0].data = temps;
      this.setState({ options });
    }
    if (prevProps.type !== type) {
      const options = { ...this.state.options };
      options.datasets[0].label = type;
      this.setState({ options });
    }
  }

  render() {
    return (
      <div>
        <Line
          data={this.state.options}
          options={{
            plugins: {
              title: {
                display: true,
                font: { size: 30 },
                align: "center"
              },
              legend: {
                display: true,
                position: "right",
                labels: { font: { size: 20 } }
              }
            }
          }}
          style={{
            border: "2px solid black",
            padding: "30px 30px 30px 40px"
          }}
        />
      </div>
    );
  }
}

export default Chart;
